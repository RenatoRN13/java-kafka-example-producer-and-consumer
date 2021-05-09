import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

@Slf4j
public class MessageDeserializer implements Deserializer<Message> {

    @Override
    public Message deserialize(String s, byte[] bytes) {
        try {
            return new ObjectMapper().readValue(bytes, Message.class);
        } catch (IOException e) {
            log.error(String.valueOf(e));
        }
        return null;
    }
}
