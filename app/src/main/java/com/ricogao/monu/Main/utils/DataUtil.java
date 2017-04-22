package com.ricogao.monu.Main.utils;

import com.ricogao.monu.Main.model.Comment;
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

    public static User getUser() {
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

    public static List<NewsItem> getCNNews() {


        NewsItem news1 = new NewsItem();
        news1.setId(1);
        news1.setImgSrc("https://s-media-cache-ak0.pinimg.com/564x/cf/d1/d3/cfd1d353b6a196dfd7843787e212faa4.jpg");
        news1.setTitle("被访问最多的花园餐厅");
        news1.setSubTitle("最新排名 2016-2017");

        NewsItem news2 = new NewsItem();
        news2.setId(2);
        news2.setImgSrc("https://s-media-cache-ak0.pinimg.com/564x/c0/2e/ac/c02eac7cb5fe6082e1c091916832c660.jpg");
        news2.setTitle("神奇的水下餐厅");
        news2.setSubTitle("你从未有过的用餐经验");

        NewsItem news3 = new NewsItem();
        news3.setId(3);
        news3.setImgSrc("https://s-media-cache-ak0.pinimg.com/564x/6b/2a/81/6b2a81e2466cca6db0d4d9ec8b328eaa.jpg");
        news3.setTitle("欧洲最好的寿司店");
        news3.setSubTitle("为寿司爱好者所推荐");

        NewsItem news4 = new NewsItem();
        news4.setId(4);
        news4.setImgSrc("https://s-media-cache-ak0.pinimg.com/564x/c1/26/4c/c1264c813c3c92336876bff7f806aa5c.jpg");
        news4.setTitle("让我们来电音乐");
        news4.setSubTitle("爵士乐和美味的食物");

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

    public static List<RecommendItem> getCNRecommends() {

        RecommendItem item1 = new RecommendItem();
        item1.setId(1);
        item1.setLiked(false);
        item1.setTitle("带我去我味去过的地方");
        item1.setName("Ithaa, 水下餐厅");
        item1.setLikes(240);
        item1.setTrending(true);
        item1.setImgSrc("https://s-media-cache-ak0.pinimg.com/564x/53/99/de/5399de46882d395ef21b325da69e857e.jpg");


        RecommendItem item2 = new RecommendItem();
        item2.setId(2);
        item2.setLiked(true);
        item2.setTitle("讨人喜爱的花园餐厅");
        item2.setName("Welly garden, 花园餐厅");
        item2.setLikes(169);
        item2.setTrending(false);
        item2.setImgSrc("https://s-media-cache-ak0.pinimg.com/564x/40/0f/44/400f442132d350f77be0853af7418e53.jpg");

        RecommendItem item3 = new RecommendItem();
        item3.setId(3);
        item3.setLiked(false);
        item3.setTitle("精致的咖啡馆");
        item3.setName("Ben lovevolley cafe, 咖啡馆");
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

    public static List<SearchItem> getCNSearchResult() {

        SearchItem item = new SearchItem();
        item.setName("Yamamoto");
        item.setKeywords("传统日式料理, 寿司");
        item.setDistance(21f);
        item.setLikes(102);
        item.setSeats(22);
        item.setAvgCost(38.5f);
        item.setId(12);
        item.setImgSrc("https://s-media-cache-ak0.pinimg.com/564x/6b/2a/81/6b2a81e2466cca6db0d4d9ec8b328eaa.jpg");

        SearchItem item2 = new SearchItem();
        item2.setName("Osaka");
        item2.setKeywords("寿司，日本酒");
        item2.setDistance(11.5f);
        item2.setLikes(95);
        item2.setSeats(28);
        item2.setAvgCost(27f);
        item2.setId(15);
        item2.setImgSrc("https://s-media-cache-ak0.pinimg.com/564x/3e/cf/0e/3ecf0e65ecfd3143b5d02d8ba08a74a3.jpg");

        SearchItem item3 = new SearchItem();
        item3.setName("Yashi 寿司餐厅");
        item3.setKeywords("传统日式料理, 寿司");
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

    public static Restaurant getCNRestaurant() {
        Restaurant item = new Restaurant();
        item.setId(123);
        item.setLiked(false);
        item.setLikes(142);
        item.setName("Yamamoto");
        item.setInfo("寿司餐厅,Ealing boradway,伦敦");
        item.setImgSrc("https://s-media-cache-ak0.pinimg.com/564x/6b/2a/81/6b2a81e2466cca6db0d4d9ec8b328eaa.jpg");
        item.setAddress("109号, Ealing broadway, 伦敦");
        item.setPhone1("(+44) 5201 203 123");
        item.setPhone2("(+44) 5201 122 959");
        item.setWorkHour1("9 a.m. - 10 p.m.");
        item.setWorkHour2("10 a.m. - 12 p.m.");
        item.setDistance("18 km 之外");
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

    public static List<MenuItem> getCNMenu() {
        MenuItem item = new MenuItem();

        item.setId(11);
        item.setName("豆腐皮寿司");
        item.setImgSrc("http://www.allaboutsushiguide.com/images/inari-sushi-1.jpg");
        item.setVeg(true);

        MenuItem item2 = new MenuItem();
        item2.setId(12);
        item2.setName("章鱼寿司");
        item2.setImgSrc("http://www.wazen.com.my/images/menu-choice/big/nigiri/3.jpg");

        MenuItem item3 = new MenuItem();
        item3.setId(13);
        item3.setName("玉子寿司");
        item3.setImgSrc("http://www.cooksinfo.com/edible.nsf/images/tamago-nigiri-sushi/$file/tamago-nigiri-sushi.jpg");

        MenuItem item4 = new MenuItem();
        item4.setId(14);
        item4.setName("三文鱼寿司");
        item4.setImgSrc("https://therawexplorerdotcom.files.wordpress.com/2013/11/bioweb.jpg");

        MenuItem item5 = new MenuItem();
        item5.setId(15);
        item5.setName("甜虾寿司");
        item5.setImgSrc("http://www.delisushi.com/87/ebi-sushi.jpg");

        MenuItem item6 = new MenuItem();
        item6.setId(16);
        item6.setName("天妇罗寿司");
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


    public static DishItem getDish() {
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


    public static DishItem getCNDish() {
        DishItem item = new DishItem();
        item.setId(123);
        item.setName("豆腐皮寿司");
        item.setCalories(102f);
        item.setPrice(1.8f);

        item.setDescription("甜味豆腐皮中塞入腌渍过的寿司米");
        item.setIngredients("甜豆腐皮，寿司米");
        item.setAllergens("面筋, 大豆, 小麦");
        item.setBestGoWith("酱油，芥末");
        item.setDishFacts("Inari（豆腐皮）是日本传统神话中的生育，大米和农业之神。");

        List<String> paths = new ArrayList<>();
        paths.add("http://www.allaboutsushiguide.com/images/inari-sushi-1.jpg");
        paths.add("http://www.delectablebakehouse.com/wp-content/uploads/2013/09/IMG_9798.jpg");
        paths.add("http://www.allaboutsushiguide.com/images/bigstock-Inari-Sushi-29945882-150.jpg");

        item.setImgSrcs(paths);

        return item;
    }


    public static List<SearchItem> getLikes() {

        SearchItem item = new SearchItem();
        item.setName("Blackfriars");
        item.setKeywords("British Cuisine, steak");
        item.setDistance(21f);
        item.setLikes(102);
        item.setSeats(22);
        item.setAvgCost(38.5f);
        item.setId(12);
        item.setImgSrc("http://i2.chroniclelive.co.uk/incoming/article1355894.ece/ALTERNATES/s615/blackfriars-restaurant-in-newcastle-859920512.jpg");

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
        item3.setName("Ithaa");
        item3.setKeywords("Underwater restaurant, experience");
        item3.setDistance(11f);
        item3.setLikes(142);
        item3.setSeats(22);
        item3.setAvgCost(32.5f);
        item3.setId(14);
        item3.setImgSrc("https://s-media-cache-ak0.pinimg.com/564x/53/99/de/5399de46882d395ef21b325da69e857e.jpg");

        List<SearchItem> items = new ArrayList<>();
        items.add(item);
        items.add(item2);
        items.add(item3);

        return items;
    }

    public static List<SearchItem> getCNLikes() {

        SearchItem item = new SearchItem();
        item.setName("Blackfriars");
        item.setKeywords("英式餐厅，牛排");
        item.setDistance(21f);
        item.setLikes(102);
        item.setSeats(22);
        item.setAvgCost(38.5f);
        item.setId(12);
        item.setImgSrc("http://i2.chroniclelive.co.uk/incoming/article1355894.ece/ALTERNATES/s615/blackfriars-restaurant-in-newcastle-859920512.jpg");

        SearchItem item2 = new SearchItem();
        item2.setName("Osaka");
        item2.setKeywords("寿司 清酒");
        item2.setDistance(11.5f);
        item2.setLikes(95);
        item2.setSeats(28);
        item2.setAvgCost(27f);
        item2.setId(15);
        item2.setImgSrc("https://s-media-cache-ak0.pinimg.com/564x/3e/cf/0e/3ecf0e65ecfd3143b5d02d8ba08a74a3.jpg");

        SearchItem item3 = new SearchItem();
        item3.setName("Ithaa");
        item3.setKeywords("水下餐厅 体验");
        item3.setDistance(11f);
        item3.setLikes(142);
        item3.setSeats(22);
        item3.setAvgCost(32.5f);
        item3.setId(14);
        item3.setImgSrc("https://s-media-cache-ak0.pinimg.com/564x/53/99/de/5399de46882d395ef21b325da69e857e.jpg");

        List<SearchItem> items = new ArrayList<>();
        items.add(item);
        items.add(item2);
        items.add(item3);

        return items;
    }


    public static List<MenuItem> getSides() {
        MenuItem item = new MenuItem();

        item.setId(11);
        item.setName("Edamame");
        item.setImgSrc("http://cdn2.momjunction.com/wp-content/uploads/2015/09/Edamame-During-Pregnancy.jpg");
        item.setVeg(true);

        MenuItem item2 = new MenuItem();
        item2.setId(12);
        item2.setName("Pork Gyoza");
        item2.setImgSrc("http://www.seriouseats.com/images/2015/03/20150309-gyoza-how-to-japanese-dumpling-recipe-open-1.jpg");

        MenuItem item3 = new MenuItem();
        item3.setId(13);
        item3.setName("Shiyo Yakitori");
        item3.setImgSrc("http://www.islandtrotters.com/assets/images/food/pork-belly-shio.jpg");

        MenuItem item4 = new MenuItem();
        item4.setId(14);
        item4.setName("Takoyaki");
        item4.setImgSrc("http://images.says.com/uploads/story/cover_image/27249/c37a.jpg");

        MenuItem item5 = new MenuItem();
        item5.setId(15);
        item5.setName("Chawanmushi");
        item5.setImgSrc("https://s-media-cache-ak0.pinimg.com/736x/4f/d3/24/4fd324f669437f4a0087ef54ca374e19.jpg");

        MenuItem item6 = new MenuItem();
        item6.setId(16);
        item6.setName("Tori kara age");
        item6.setImgSrc("https://upload.wikimedia.org/wikipedia/commons/0/0b/Tori_karaage_by_clanchou_in_Kanazawa%2C_Ishikawa.jpg");

        List<MenuItem> items = new ArrayList<>();
        items.add(item);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);

        return items;
    }

    public static List<MenuItem> getCNSides() {
        MenuItem item = new MenuItem();

        item.setId(11);
        item.setName("枝豆");
        item.setImgSrc("http://cdn2.momjunction.com/wp-content/uploads/2015/09/Edamame-During-Pregnancy.jpg");
        item.setVeg(true);

        MenuItem item2 = new MenuItem();
        item2.setId(12);
        item2.setName("猪肉饺子");
        item2.setImgSrc("http://www.seriouseats.com/images/2015/03/20150309-gyoza-how-to-japanese-dumpling-recipe-open-1.jpg");

        MenuItem item3 = new MenuItem();
        item3.setId(13);
        item3.setName("盐烧鸡肉串");
        item3.setImgSrc("http://www.islandtrotters.com/assets/images/food/pork-belly-shio.jpg");

        MenuItem item4 = new MenuItem();
        item4.setId(14);
        item4.setName("章鱼小丸子");
        item4.setImgSrc("http://images.says.com/uploads/story/cover_image/27249/c37a.jpg");

        MenuItem item5 = new MenuItem();
        item5.setId(15);
        item5.setName("茶碗蒸");
        item5.setImgSrc("https://s-media-cache-ak0.pinimg.com/736x/4f/d3/24/4fd324f669437f4a0087ef54ca374e19.jpg");

        MenuItem item6 = new MenuItem();
        item6.setId(16);
        item6.setName("炸鸡块");
        item6.setImgSrc("https://upload.wikimedia.org/wikipedia/commons/0/0b/Tori_karaage_by_clanchou_in_Kanazawa%2C_Ishikawa.jpg");

        List<MenuItem> items = new ArrayList<>();
        items.add(item);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);

        return items;
    }


    public static List<MenuItem> getDessert() {
        MenuItem item = new MenuItem();

        item.setId(11);
        item.setName("Apple Tempura");
        item.setImgSrc("http://4.bp.blogspot.com/-6sN-UBZUbM4/TZMpV6dkv0I/AAAAAAAAAbM/mip8mMVwpXA/s1600/P1030809.JPG");
        item.setVeg(true);

        MenuItem item2 = new MenuItem();
        item2.setId(12);
        item2.setName("Fried Ice cream");
        item2.setImgSrc("https://shewearsmanyhats.com/wp-content/uploads/2013/08/fried-ice-cream-unfried-recipe-6new.jpg");

        MenuItem item3 = new MenuItem();
        item3.setId(13);
        item3.setName("Daifuku");
        item3.setImgSrc("https://trendingjapan.files.wordpress.com/2016/02/ichigo_daifuku.png?w=636");

        MenuItem item4 = new MenuItem();
        item4.setId(14);
        item4.setName("Dorayaki");
        item4.setVeg(true);
        item4.setImgSrc("http://1.bp.blogspot.com/-Hnn3AmPgy-U/UxHUFS3mWxI/AAAAAAAANH8/IjePVlUQiDs/s1600/Dorayaki.jpg");

        MenuItem item5 = new MenuItem();
        item5.setId(15);
        item5.setName("Banana boat");
        item5.setImgSrc("https://s-media-cache-ak0.pinimg.com/736x/96/ce/8b/96ce8be0c945be04f606d987746e35a8.jpg");

        MenuItem item6 = new MenuItem();
        item6.setId(16);
        item6.setName("Mochi");
        item6.setVeg(true);
        item6.setImgSrc("https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Mochi_002.jpg/1200px-Mochi_002.jpg");

        List<MenuItem> items = new ArrayList<>();
        items.add(item);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);

        return items;
    }

    public static List<MenuItem> getCNDessert() {
        MenuItem item = new MenuItem();

        item.setId(11);
        item.setName("苹果天妇罗");
        item.setImgSrc("http://4.bp.blogspot.com/-6sN-UBZUbM4/TZMpV6dkv0I/AAAAAAAAAbM/mip8mMVwpXA/s1600/P1030809.JPG");
        item.setVeg(true);

        MenuItem item2 = new MenuItem();
        item2.setId(12);
        item2.setName("炸雪糕");
        item2.setImgSrc("https://shewearsmanyhats.com/wp-content/uploads/2013/08/fried-ice-cream-unfried-recipe-6new.jpg");

        MenuItem item3 = new MenuItem();
        item3.setId(13);
        item3.setName("大福");
        item3.setImgSrc("https://trendingjapan.files.wordpress.com/2016/02/ichigo_daifuku.png?w=636");

        MenuItem item4 = new MenuItem();
        item4.setId(14);
        item4.setName("铜锣烧");
        item4.setVeg(true);
        item4.setImgSrc("http://1.bp.blogspot.com/-Hnn3AmPgy-U/UxHUFS3mWxI/AAAAAAAANH8/IjePVlUQiDs/s1600/Dorayaki.jpg");

        MenuItem item5 = new MenuItem();
        item5.setId(15);
        item5.setName("香蕉船");
        item5.setImgSrc("https://s-media-cache-ak0.pinimg.com/736x/96/ce/8b/96ce8be0c945be04f606d987746e35a8.jpg");

        MenuItem item6 = new MenuItem();
        item6.setId(16);
        item6.setName("年糕");
        item6.setVeg(true);
        item6.setImgSrc("https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Mochi_002.jpg/1200px-Mochi_002.jpg");

        List<MenuItem> items = new ArrayList<>();
        items.add(item);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);

        return items;
    }

    public static List<MenuItem> getDrinks() {
        MenuItem item = new MenuItem();

        item.setId(11);
        item.setName("Gekkeikan");
        item.setImgSrc("https://www.japaneseflavours.com/28-tm_thickbox_default/gekkeikan-sake-750ml.jpg");

        MenuItem item2 = new MenuItem();
        item2.setId(12);
        item2.setName("Hakushika Ginjou");
        item2.setImgSrc("http://s7d9.scene7.com/is/image/SAQ/11156570_is?$saq-prod-tra$");

        MenuItem item3 = new MenuItem();
        item3.setId(13);
        item3.setName("Merlot");
        item3.setImgSrc("http://www.redwoodcreek.com/resources/images/wines/red/detail/merlot.png");

        MenuItem item4 = new MenuItem();
        item4.setId(14);
        item4.setName("Asahi");
        item4.setImgSrc("https://www.europafoodxb.com/static/images/productimage-picture-asahi-4941.jpg");


        List<MenuItem> items = new ArrayList<>();
        items.add(item);
        items.add(item2);
        items.add(item3);
        items.add(item4);

        return items;
    }

    public static List<MenuItem> getCNDrinks() {
        MenuItem item = new MenuItem();

        item.setId(11);
        item.setName("桂月冠");
        item.setImgSrc("https://www.japaneseflavours.com/28-tm_thickbox_default/gekkeikan-sake-750ml.jpg");

        MenuItem item2 = new MenuItem();
        item2.setId(12);
        item2.setName("白鹿吟酿");
        item2.setImgSrc("http://s7d9.scene7.com/is/image/SAQ/11156570_is?$saq-prod-tra$");

        MenuItem item3 = new MenuItem();
        item3.setId(13);
        item3.setName("梅洛特");
        item3.setImgSrc("http://www.redwoodcreek.com/resources/images/wines/red/detail/merlot.png");

        MenuItem item4 = new MenuItem();
        item4.setId(14);
        item4.setName("朝日啤酒");
        item4.setImgSrc("https://www.europafoodxb.com/static/images/productimage-picture-asahi-4941.jpg");


        List<MenuItem> items = new ArrayList<>();
        items.add(item);
        items.add(item2);
        items.add(item3);
        items.add(item4);

        return items;
    }

    public static List<Comment> getComments() {
        List<Comment> list = new ArrayList<>();

        Comment comment = new Comment();
        comment.setName("JaneWaston");
        comment.setComment("Very tasty, beancurd goes very well with the sticky rice");
        comment.setImgSrc("http://socialventurepartners.s3-us-west-2.amazonaws.com/www.socialventurepartners.org/sites/43/2013/08/Jane-Ragle.jpg");

        Comment comment1 = new Comment();
        comment1.setName("BenWake");
        comment1.setComment("Nice dish, the story behind the dish is also very interesting.");
        comment1.setImgSrc("https://pbs.twimg.com/profile_images/595898348311334913/g1aiOY-E.jpg");

        Comment comment2 = new Comment();
        comment2.setName("JameGreen");
        comment2.setComment("This dish taste as lovely as it looks.");
        comment2.setImgSrc("http://www.magnetic.com/wp-content/uploads/JamesGreen.jpg");

        list.add(comment);
        list.add(comment1);
        list.add(comment2);

        return list;
    }

    public static List<Comment> getCNComments() {
        List<Comment> list = new ArrayList<>();

        Comment comment = new Comment();
        comment.setName("JaneWaston");
        comment.setComment("非常美味，豆腐皮和寿司米是很好的搭配。");
        comment.setImgSrc("http://socialventurepartners.s3-us-west-2.amazonaws.com/www.socialventurepartners.org/sites/43/2013/08/Jane-Ragle.jpg");

        Comment comment1 = new Comment();
        comment1.setName("BenWake");
        comment1.setComment("味道很好，这个菜品背后的故事页很吸引人。");
        comment1.setImgSrc("https://pbs.twimg.com/profile_images/595898348311334913/g1aiOY-E.jpg");

        Comment comment2 = new Comment();
        comment2.setName("JameGreen");
        comment2.setComment("这道菜品就好像它看上去那么美味。");
        comment2.setImgSrc("http://www.magnetic.com/wp-content/uploads/JamesGreen.jpg");

        list.add(comment);
        list.add(comment1);
        list.add(comment2);

        return list;
    }
}
