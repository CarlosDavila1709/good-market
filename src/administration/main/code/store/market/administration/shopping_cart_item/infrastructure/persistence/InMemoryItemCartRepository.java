package store.market.administration.shopping_cart_item.infrastructure.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import store.market.administration.shopping_cart_item.domain.CartItem;
import store.market.administration.shopping_cart_item.domain.CartItemProductId;
import store.market.administration.shopping_cart_item.domain.ItemCartRepository;
import store.market.shared.domain.Service;
import store.market.shared.domain.criteria.Criteria;


public final class InMemoryItemCartRepository   {

    private HashMap<String, List<CartItem>> items = new HashMap<>();



}
