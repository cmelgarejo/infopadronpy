package py.com.infopadron.dto;

/**
 * Created by willynx.
 */
public abstract class BaseDTO {
  private static final String DTO_SUFFIX = "DTO";

  public abstract Long getId();

  public static String getJSONFileName(Class<?> clazz) {
    StringBuffer retorno = new StringBuffer();
    if (clazz != null) {
      String simpleName = clazz.getSimpleName();
      retorno.append(simpleName.substring(0, simpleName.indexOf(DTO_SUFFIX)));
      retorno.append(".json");
    }
    return retorno.toString();
  }
}
