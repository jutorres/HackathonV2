package Converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.*;

import com.stefanini.hackathon2.entidades.Dog;
import com.stefanini.hackathon2.servicos.DogServico;
 
 
@FacesConverter(forClass = com.stefanini.hackathon2.entidades.Dog.class)
public class DogConverter implements Converter {
 
    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
        DogServico dogServico = new DogServico();
        int dogId;
 
        try {
            dogId = Integer.parseInt(arg2);
        } catch (NumberFormatException exception) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Type the name of a Dog and select it (or use the dropdow)", "Type the name of a Dog and select it (or use the dropdow)"));
        }
 
        return dogServico.findDog(dogId);
    }
 
    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
 
        if (arg2 == null) {
            return "";
        }
        Dog dog = (Dog) arg2;
        return String.valueOf(dog.getId());
    }
}
