package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {


    @Test
    void StringSchemaTest(){
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
    void NumberSchemaTest(){
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
}