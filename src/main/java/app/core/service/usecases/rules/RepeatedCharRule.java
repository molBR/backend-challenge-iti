package app.core.service.usecases.rules;

public class RepeatedCharRule extends Rule {

    public boolean compareStringChar(char c, String restOfString){
        return compareString(c, restOfString);
    }
}
