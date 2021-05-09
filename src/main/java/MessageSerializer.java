import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serializer;

@Slf4j
public class MessageSerializer implements Serializer<Message> {
    @Override
    public byte[] serialize(String s, Message message) {
        try {
            return new ObjectMapper().writeValueAsBytes(message);
        } catch (JsonProcessingException e) {
            log.error(String.valueOf(e));
        }
        return null;
    }
}
