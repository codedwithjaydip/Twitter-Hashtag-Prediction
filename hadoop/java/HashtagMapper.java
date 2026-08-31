import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class HashtagMapper
        extends Mapper<LongWritable, Text, Text, Text> {

    private Text hashtag = new Text();
    private Text engagement = new Text();

    @Override
    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {

        String line = value.toString();

        // Skip CSV header
        if (line.startsWith("Hashtag")) {
            return;
        }

        // Find first comma
        int firstComma = line.indexOf(',');

        // Find last two commas
        int lastComma = line.lastIndexOf(',');
        int secondLastComma = line.lastIndexOf(',', lastComma - 1);

        if (firstComma != -1 &&
            secondLastComma != -1 &&
            lastComma != -1) {

            String tag = line.substring(0, firstComma).trim();

            String likes = line.substring(
                    secondLastComma + 1,
                    lastComma
            ).trim();

            String retweets = line.substring(
                    lastComma + 1
            ).trim();

            hashtag.set(tag);
            engagement.set(likes + "," + retweets);

            context.write(hashtag, engagement);
        }
    }
}
