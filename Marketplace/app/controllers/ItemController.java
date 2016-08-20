package controllers;

import dispatchers.AkkaDispatcher;
import java.util.concurrent.CompletableFuture;
import play.mvc.*;
import static play.libs.Json.toJson;
import models.ItemEntity;
import akka.dispatch.MessageDispatcher;

import java.util.concurrent.CompletionStage;
import play.libs.Json;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * Created by ea.margffoy10 on 20/08/2016.
 */
public class ItemController extends Controller
{
	public CompletionStage<Result> getItems() 
	{
		MessageDispatcher jdbcDispatcher = AkkaDispatcher.jdbcDispatcher;

	    return CompletableFuture.
                supplyAsync(
                        () -> {
                            return ItemEntity.FINDER.all();
                        }
                        ,jdbcDispatcher)
                .thenApply(
                        items -> {
                            return ok(toJson(items));
                        }
                );
	}

	public CompletionStage<Result> createItem()
    {
        MessageDispatcher jdbcDispatcher = AkkaDispatcher.jdbcDispatcher;
        JsonNode nItem = request().body().asJson();
        ItemEntity item = Json.fromJson( nItem , ItemEntity.class );
        return CompletableFuture.
                supplyAsync(
                        () -> {
                            item.save();
                            return item;
                        }
                        ,jdbcDispatcher)
                .thenApply(
                        itemEntities -> {
                            return ok(toJson(itemEntities));
                        }
                );
    }

}
