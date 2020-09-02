package bookRental;

import bookRental.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{

    @Autowired
    PointRepository pointRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverConfirmSucceeded_SavePoint(@Payload ConfirmSucceeded confirmSucceeded){

        if(confirmSucceeded.isMe()){
            System.out.println("##### listener SavePoint : " + confirmSucceeded.toJson());
            Point point = new Point();

            if(("").equals(confirmSucceeded.getBookingId())){
                point.setBookingId(5L);
            }
            else
                point.setBookingId(confirmSucceeded.getBookingId());
            point.setPointStatus("SAVE point!!!");

            pointRepository.save(point);
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverConfirmCanceled_CancelPoint(@Payload ConfirmCanceled confirmCanceled){

        if(confirmCanceled.isMe()){
            System.out.println("##### listener CancelPoint : " + confirmCanceled.toJson());
            Point point = new Point();

            if(("").equals(confirmCanceled.getBookingId())){
                point.setBookingId(5L);
            }
            else
                point.setBookingId(confirmCanceled.getBookingId());
            point.setPointStatus("CANCEL point!!!");

            pointRepository.save(point);
        }
    }

}
