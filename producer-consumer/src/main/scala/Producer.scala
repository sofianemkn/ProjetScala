import java.util.Properties
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import spray.json._

object Producer extends App {

  val props:Properties = new Properties()

  props.put("bootstrap.servers","localhost:9092")
  props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  props.put("acks","all")

  val producer = new KafkaProducer[String, String](props)

  var a = 0

  try {

    val bufferedSource = io.Source.fromFile("./template.csv")

    bufferedSource.getLines.foreach(line => {

      a += 1

      if ((a%2) == 0){

        val record = new ProducerRecord[String, String]("test", "1", JsObject("val" -> JsString(line)).toString())
        val metadata = producer.send(record)
      }
      else{

        val record = new ProducerRecord[String, String]("test2", "1", line)
        val metadata = producer.send(record)
      }

    })

    bufferedSource.close

  }catch{
    case e:Exception => e.printStackTrace()
  }finally {
    producer.close()
  }
}
