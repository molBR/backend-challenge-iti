package app.core.service.usecases.rules.AbstractRules;

import app.core.service.usecases.rules.Rule;

public interface AbstractRule extends Rule {

    boolean validateRule(char p);

    @Override
    boolean getFlag();
}
