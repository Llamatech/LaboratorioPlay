package controllers;

import dispatchers.AkkaDispatcher;
import java.util.concurrent.CompletableFuture;
import play.mvc.*;
import static play.libs.Json.toJson;
import models.WishListEntity;
import akka.dispatch.MessageDispatcher;

import java.util.concurrent.CompletionStage;
import play.libs.Json;
import com.fasterxml.jackson.databind.JsonNode;


/**
 * Created by ea.margffoy10 on 20/08/2016.
 */
public class WishListController extends Controller
{
    public CompletionStage<Result> getWishLists() {
        MessageDispatcher jdbcDispatcher = AkkaDispatcher.jdbcDispatcher;

        return CompletableFuture.
                supplyAsync(
                        () -> {
                            return WishListEntity.FINDER.all();
                        }
                        ,jdbcDispatcher)
                .thenApply(
                        wishListEnt -> {
                            return ok(toJson(wishListEnt));
                        }
                );
    }

    public CompletionStage<Result> createWishList()
    {
        MessageDispatcher jdbcDispatcher = AkkaDispatcher.jdbcDispatcher;
        JsonNode nWishList = request().body().asJson();
        WishListEntity wishList = Json.fromJson( nWishList , WishListEntity.class );
        return CompletableFuture.
                supplyAsync(
                        () -> {
                            wishList.save();
                            return wishList;
                        }
                        ,jdbcDispatcher)
                .thenApply(
                        productEntities -> {
                            return ok(toJson(productEntities));
                        }
                );
    }

}
