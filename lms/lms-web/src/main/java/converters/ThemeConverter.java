package converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import beans.CourseBean;
import entities.Theme;

@FacesConverter("tc")
public class ThemeConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.trim().equals("")) {
			return null;
		} else {
			CourseBean courseBean = context.getApplication().evaluateExpressionGet(context, "#{courseBean}",
					CourseBean.class);
			return courseBean.doFindThemeByName(value);
		}

	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null || value.equals("")) {
			return "";
		} else {

			return ((Theme) value).getName();
		}

	}

}
