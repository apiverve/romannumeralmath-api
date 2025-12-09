// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     RomanNumeralMathData data = Converter.fromJsonString(jsonString);

package com.apiverve.romannumeralmath.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static RomanNumeralMathData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(RomanNumeralMathData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(RomanNumeralMathData.class);
        writer = mapper.writerFor(RomanNumeralMathData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// RomanNumeralMathData.java

package com.apiverve.romannumeralmath.data;

import com.fasterxml.jackson.annotation.*;

public class RomanNumeralMathData {
    private String roman1;
    private String roman2;
    private long roman1Value;
    private long roman2Value;
    private String operation;
    private long resultNumber;
    private String resultRoman;
    private String equationNumeric;
    private String equationRoman;

    @JsonProperty("roman1")
    public String getRoman1() { return roman1; }
    @JsonProperty("roman1")
    public void setRoman1(String value) { this.roman1 = value; }

    @JsonProperty("roman2")
    public String getRoman2() { return roman2; }
    @JsonProperty("roman2")
    public void setRoman2(String value) { this.roman2 = value; }

    @JsonProperty("roman1_value")
    public long getRoman1Value() { return roman1Value; }
    @JsonProperty("roman1_value")
    public void setRoman1Value(long value) { this.roman1Value = value; }

    @JsonProperty("roman2_value")
    public long getRoman2Value() { return roman2Value; }
    @JsonProperty("roman2_value")
    public void setRoman2Value(long value) { this.roman2Value = value; }

    @JsonProperty("operation")
    public String getOperation() { return operation; }
    @JsonProperty("operation")
    public void setOperation(String value) { this.operation = value; }

    @JsonProperty("result_number")
    public long getResultNumber() { return resultNumber; }
    @JsonProperty("result_number")
    public void setResultNumber(long value) { this.resultNumber = value; }

    @JsonProperty("result_roman")
    public String getResultRoman() { return resultRoman; }
    @JsonProperty("result_roman")
    public void setResultRoman(String value) { this.resultRoman = value; }

    @JsonProperty("equation_numeric")
    public String getEquationNumeric() { return equationNumeric; }
    @JsonProperty("equation_numeric")
    public void setEquationNumeric(String value) { this.equationNumeric = value; }

    @JsonProperty("equation_roman")
    public String getEquationRoman() { return equationRoman; }
    @JsonProperty("equation_roman")
    public void setEquationRoman(String value) { this.equationRoman = value; }
}