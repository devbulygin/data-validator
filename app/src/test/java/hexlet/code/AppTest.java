package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class AppTest {


    @Test
    void stringSchemaTest() {
        Validator v = new Validator();

        StringSchema schema = v.string();

        assertThat(schema.isValid("")).isTrue();
        assertThat(schema.isValid(null)).isTrue();

        schema.required();
        assertThat(schema.isValid("what does the fox say")).isTrue();
        assertThat(schema.isValid("")).isFalse();
        assertThat(schema.isValid(5)).isFalse();
        assertThat(schema.isValid(null)).isFalse();


        schema.minLength(7);

        assertThat(schema.isValid("hexlet")).isFalse();
        assertThat(schema.isValid("torrent")).isTrue();
        assertThat(schema.isValid("calendar")).isTrue();
        assertThat(schema.isValid(null)).isFalse();

        schema.contains("wh");
        assertThat(schema.isValid("what does the fox say")).isTrue();

        schema.contains("what");
        assertThat(schema.isValid("what does the fox say")).isTrue();

        schema.contains("whatthe");
        assertThat(schema.isValid("what does the fox say")).isFalse();
        assertThat(schema.isValid("what does the fox say")).isFalse();

    }

    @Test
    void numberSchemaTest() {
        Validator v = new Validator();

        NumberSchema schema = v.number();

        assertThat(schema.positive().isValid(null)).isTrue();


        schema.required();

        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid(10)).isTrue();
        assertThat(schema.isValid("5")).isFalse();
        assertThat(schema.isValid(-10)).isFalse();
        assertThat(schema.isValid(0)).isFalse();

        schema.range(5, 10);

        assertThat(schema.isValid(5)).isTrue();
        assertThat(schema.isValid(10)).isTrue();
        assertThat(schema.isValid(4)).isFalse();
        assertThat(schema.isValid(11)).isFalse();

    }

    @Test
    void mapSchemaTest() {
        Validator v = new Validator();

        MapSchema schema = v.map();

        assertThat(schema.isValid(null)).isTrue();


        schema.required();

        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid(new HashMap<>())).isTrue();

        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");

        assertThat(schema.isValid(data)).isTrue();

        schema.sizeof(2);

        assertThat(schema.isValid(data)).isFalse();

        data.put("key2", "value2");

        assertThat(schema.isValid(data)).isTrue();
    }

    @Test
    void mapInsideTest() {
        Validator v = new Validator();

        MapSchema schema = v.map();

        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", v.string().required());
        schemas.put("age", v.number().positive());
        schema.shape(schemas);


        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", 100);

        assertThat(schema.isValid(human1)).isTrue();

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);

        assertThat(schema.isValid(human2)).isTrue();

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);

        assertThat(schema.isValid(human3)).isFalse();


    }
}

