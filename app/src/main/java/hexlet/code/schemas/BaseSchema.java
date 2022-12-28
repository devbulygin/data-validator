package hexlet.code.schemas;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema {
    private final Map<String, Predicate<Object>> checks;

    protected BaseSchema() {
        this.checks = new LinkedHashMap<>();
    }

    protected final void addChecks(String name, Predicate<Object> check) {
        checks.put(name, check);
    }

    public final Map<String, Predicate<Object>> getChecks() {
        return checks;
    }

    public final boolean isValid(Object object) {
        return checks.values().stream().allMatch(check -> check.test(object));
    }

}
