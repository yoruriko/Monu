package com.ricogao.monu.Main.utils;

import com.ricogao.monu.Main.model.DishItem;
import com.ricogao.monu.Main.model.MenuItem;
import com.ricogao.monu.Main.model.NewsItem;
import com.ricogao.monu.Main.model.RecommendItem;
import com.ricogao.monu.Main.model.Restaurant;
import com.ricogao.monu.Main.model.SearchItem;
import com.ricogao.monu.Main.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ricogao on 2017/4/21.
 */

public class DataUtil {

    public static User getUser(){
        User user = new User();

        user.setId(12);
        user.setUserName("Johnathan_33");
        user.setEmail("heyfromjonathan@gmail.com");
        user.setImgSrc("https://geo.appstate.edu/sites/geo.appstate.edu/files/Sugg%2C%20J.jpg");

        return user;
    }

    public static List<NewsItem> getNews() {


        NewsItem news1 = new NewsItem();
        news1.setId(1);
        news1.setImgSrc("https://s-media-cache-ak0.pinimg.com/564x/cf/d1/d3/cfd1d353b6a196dfd7843787e212faa4.jpg");
        news1.setTitle("Most visited garden restaurants");
        news1.setSubTitle("latest ranking 2016-2017");

        NewsItem news2 = new NewsItem();
        news2.setId(2);
        news2.setImgSrc("https://s-media-cache-ak0.pinimg.com/564x/c0/2e/ac/c02eac7cb5fe6082e1c091916832c660.jpg");
        news2.setTitle("Amazing under water restaurant");
        news2.setSubTitle("Experience you never had");

        NewsItem news3 = new NewsItem();
        news3.setId(3);
        news3.setImgSrc("https://s-media-cache-ak0.pinimg.com/564x/6b/2a/81/6b2a81e2466cca6db0d4d9ec8b328eaa.jpg");
        news3.setTitle("Best Sushi bar in the EU");
        news3.setSubTitle("Recommendation for Sushi lovers");

        NewsItem news4 = new NewsItem();
        news4.setId(4);
        news4.setImgSrc("https://s-media-cache-ak0.pinimg.com/564x/c1/26/4c/c1264c813c3c92336876bff7f806aa5c.jpg");
        news4.setTitle("Let's have some music");
        news4.setSubTitle("Jazz and amazing food");

        List<NewsItem> items = new ArrayList<>();
        items.add(news1);
        items.add(news2);
        items.add(news3);
        items.add(news4);

        return items;
    }

    public static List<RecommendItem> getRecommends() {

        RecommendItem item1 = new RecommendItem();
        item1.setId(1);
        item1.setLiked(false);
        item1.setTitle("Take Me To Place I Never Knew");
        item1.setName("Ithaa, underwater restaurant");
        item1.setLikes(240);
        item1.setTrending(true);
        item1.setImgSrc("https://s-media-cache-ak0.pinimg.com/564x/53/99/de/5399de46882d395ef21b325da69e857e.jpg");


        RecommendItem item2 = new RecommendItem();
        item2.setId(2);
        item2.setLiked(true);
        item2.setTitle("Lovely garden restaurant");
        item2.setName("Welly garden, garden restaurant");
        item2.setLikes(169);
        item2.setTrending(false);
        item2.setImgSrc("https://s-media-cache-ak0.pinimg.com/564x/40/0f/44/400f442132d350f77be0853af7418e53.jpg");

        RecommendItem item3 = new RecommendItem();
        item3.setId(3);
        item3.setLiked(false);
        item3.setTitle("Lovely cafe");
        item3.setName("Ben lovevolley cafe");
        item3.setLikes(169);
        item3.setTrending(false);
        item3.setImgSrc("https://s-media-cache-ak0.pinimg.com/564x/91/d8/e6/91d8e6ecc497f9c12ff0af035b74803d.jpg");

        List<RecommendItem> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);

        return items;
    }

    public static List<SearchItem> getSearchResult() {

        SearchItem item = new SearchItem();
        item.setName("Yamamoto");
        item.setKeywords("Traditional Japanese dish, Sushi");
        item.setDistance(21f);
        item.setLikes(102);
        item.setSeats(22);
        item.setAvgCost(38.5f);
        item.setId(12);
        item.setImgSrc("https://s-media-cache-ak0.pinimg.com/564x/6b/2a/81/6b2a81e2466cca6db0d4d9ec8b328eaa.jpg");

        SearchItem item2 = new SearchItem();
        item2.setName("Osaka");
        item2.setKeywords("Sushi, Saki");
        item2.setDistance(11.5f);
        item2.setLikes(95);
        item2.setSeats(28);
        item2.setAvgCost(27f);
        item2.setId(15);
        item2.setImgSrc("https://s-media-cache-ak0.pinimg.com/564x/3e/cf/0e/3ecf0e65ecfd3143b5d02d8ba08a74a3.jpg");

        SearchItem item3 = new SearchItem();
        item3.setName("Yashi sushi bar");
        item3.setKeywords("Traditional Japanese dish, Sushi");
        item3.setDistance(11f);
        item3.setLikes(142);
        item3.setSeats(22);
        item3.setAvgCost(32.5f);
        item3.setId(14);
        item3.setImgSrc("https://s-media-cache-ak0.pinimg.com/564x/6a/34/eb/6a34ebcfef799bd6cf666139875b797c.jpg");

        List<SearchItem> items = new ArrayList<>();
        items.add(item);
        items.add(item2);
        items.add(item3);

        return items;
    }

    public static Restaurant getRestaurant() {
        Restaurant item = new Restaurant();
        item.setId(123);
        item.setLiked(false);
        item.setLikes(142);
        item.setName("Yamamoto");
        item.setInfo("Sushi bar,Ealing Broadway,London");
        item.setImgSrc("https://s-media-cache-ak0.pinimg.com/564x/6b/2a/81/6b2a81e2466cca6db0d4d9ec8b328eaa.jpg");
        item.setAddress("No. 109, Ealing broadway, London");
        item.setPhone1("(+44) 5201 203 123");
        item.setPhone2("(+44) 5201 122 959");
        item.setWorkHour1("9 a.m. - 10 p.m.");
        item.setWorkHour2("10 a.m. - 12 p.m.");
        item.setDistance("18 km away");
        item.setSeatsState(18);
        return item;
    }

    public static List<MenuItem> getMenu() {
        MenuItem item = new MenuItem();

        item.setId(11);
        item.setName("Inari Sushi");
        item.setImgSrc("http://www.allaboutsushiguide.com/images/inari-sushi-1.jpg");
        item.setVeg(true);

        MenuItem item2 = new MenuItem();
        item2.setId(12);
        item2.setName("Toko Sushi");
        item2.setImgSrc("http://www.wazen.com.my/images/menu-choice/big/nigiri/3.jpg");

        MenuItem item3 = new MenuItem();
        item3.setId(13);
        item3.setName("Tamago Sushi");
        item3.setImgSrc("http://www.cooksinfo.com/edible.nsf/images/tamago-nigiri-sushi/$file/tamago-nigiri-sushi.jpg");

        MenuItem item4 = new MenuItem();
        item4.setId(14);
        item4.setName("Salmon Sushi");
        item4.setImgSrc("https://therawexplorerdotcom.files.wordpress.com/2013/11/bioweb.jpg");

        MenuItem item5 = new MenuItem();
        item5.setId(15);
        item5.setName("Ebi Sushi");
        item5.setImgSrc("http://www.delisushi.com/87/ebi-sushi.jpg");

        MenuItem item6 = new MenuItem();
        item6.setId(16);
        item6.setName("Tempura Sushi");
        item6.setImgSrc("https://i.ytimg.com/vi/1QvnvdEOzSM/maxresdefault.jpg");

        List<MenuItem> items = new ArrayList<>();
        items.add(item);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);

        return items;
    }


    public static DishItem getDish(){
        DishItem item = new DishItem();
        item.setId(123);
        item.setName("Inari Sushi");
        item.setCalories(102f);
        item.setPrice(1.8f);

        item.setDescription("Sweet parcels of soft beancurd filled with sticky rice.");
        item.setIngredients("Sweet beancurd, sticky rice");
        item.setAllergens("Gluten, Soya, Wheat");
        item.setBestGoWith("Soy sauce, wasabi");
        item.setDishFacts("Inari is named for the shinto (A Japanese ethnic religion) god of fertility, rice and agriculture.");

        List<String> paths = new ArrayList<>();
        paths.add("http://www.allaboutsushiguide.com/images/inari-sushi-1.jpg");
        paths.add("http://www.delectablebakehouse.com/wp-content/uploads/2013/09/IMG_9798.jpg");
        paths.add("http://www.allaboutsushiguide.com/images/bigstock-Inari-Sushi-29945882-150.jpg");

        item.setImgSrcs(paths);

        return item;
    }
}
