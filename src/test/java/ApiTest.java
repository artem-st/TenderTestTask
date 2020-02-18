import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;

class ApiTest {
    @Test
    void test1() throws IOException {

        //Параметры вызова API
        ArrayList<String> params = new ArrayList<String>();
        params.add("_company.info_public.json?");
        params.add("id=61098");

        //Отправка запроса к API
        String result = HttpUtils.sendGetRequest(params);

        //Парсинг ответа и проверка значений нескольких произвольных полей
        JSONObject obj = new JSONObject(result);
        System.out.println(result);

        String titleFull = obj.getJSONObject("result").getJSONObject("data").get("title_full").toString();
        String rating = obj.getJSONObject("result").getJSONObject("data").get("rating").toString();
        String phone = obj.getJSONObject("result").getJSONObject("data").get("phone").toString();

        Assertions.assertEquals("АО \"Русская медная компания\"", titleFull, "Значения не совпадают");
        Assertions.assertEquals("1.915", rating, "Значения не совпадают");
        Assertions.assertEquals("+7-343-311-11-76", phone, "Значения не совпадают");
    }
}
