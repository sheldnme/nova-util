package com.xss.common.nova.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.apache.commons.lang3.time.FastDateFormat;

import java.io.IOException;
import java.util.Date;
import java.util.TimeZone;

public class ToTimeFormat extends StdSerializer<Date> {
    private static FastDateFormat formatter = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss", TimeZone.getTimeZone("GMT+8"));

    public ToTimeFormat() {
        this(null);
    }

    public ToTimeFormat(Class<Date> t) {
        super(t);
    }

    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (date == null) {
            jsonGenerator.writeString((String) null);
        } else {
            jsonGenerator.writeString(formatter.format(date));
        }
    }
}
