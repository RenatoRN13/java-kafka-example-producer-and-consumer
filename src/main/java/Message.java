import lombok.Getter;
import lombok.Setter;
import org.apache.kafka.common.serialization.Serializer;

@Getter
@Setter
public class Message implements Serializer {
    private String id;

    @Override
    public byte[] serialize(String s, Object o) {
        return new byte[0];
    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                '}';
    }
}
