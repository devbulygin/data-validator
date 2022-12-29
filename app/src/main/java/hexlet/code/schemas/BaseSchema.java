package hexlet.code.schemas;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema {
    private final Map<String, Predicate<Object>> checks;
    protected BaseSchema() {
        this.checks = new LinkedHashMap<>();
    }
    protected boolean required = false;
    protected final void addChecks(String name, Predicate validate) {
        checks.put(name, validate);
    }
    public final boolean isValid(Object object) {
        return checks.values().stream().allMatch(check -> check.test(object));
    }
}
