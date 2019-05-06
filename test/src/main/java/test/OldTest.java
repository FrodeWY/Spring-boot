package test;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OldTest {

  private final static JsonParser GSON_PARSER = new JsonParser();
  private final static Gson GSON_INSTANCE = new Gson();
  @GetMapping("/old")
  public String test1(HttpServletRequest request) {
    String v1 = request.getParameter("v1");
    String v2 = request.getParameter("v2");
    String v3 = request.getParameter("v3");
    return v1 + v2 + v3;
  }

  @PostMapping("/old")
  public String test2(HttpServletRequest request) {
    JsonObject jsonObject = getBodyAsJsonObject(request);
    User u1 = toObject(jsonObject.toString(), User.class);
    String v2 = request.getParameter("v2");
    String v3 = request.getParameter("v3");
    return v2 + v3 + u1.getId() + u1.getName();
  }

  protected JsonObject getBodyAsJsonObject(HttpServletRequest request) {
    return toJsonObject(this.getBody(request));
  }
  public String getBody(HttpServletRequest request) {
    String ret = null;
    try {
      ret = toString(request.getInputStream());
    } catch (Exception e) {
    }
    return ret == null ? "" : ret;
  }
  public static String toString(InputStream in) {
    String ret = null;
    try {
      ByteArrayOutputStream boa = new ByteArrayOutputStream();
      int len = 0;
      byte[] buffer = new byte[1024];

      while ((len = in.read(buffer)) != -1) {
        boa.write(buffer, 0, len);
      }
      boa.close();
      ret = new String(boa.toByteArray(), "utf-8");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return ret;
  }


  public static JsonObject toJsonObject(String str) {
    JsonElement element = null;
    if (str != null) {
      element = GSON_PARSER.parse(str);
    }
    return element != null && element.isJsonObject() ? element.getAsJsonObject() : null;
  }

  public static <T> T toObject(String str, Class<T> clazz) {
    return (str == null || clazz == null) ? null : GSON_INSTANCE.fromJson(str, clazz);
  }
}
