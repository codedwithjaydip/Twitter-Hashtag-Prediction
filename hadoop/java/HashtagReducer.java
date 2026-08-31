import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class HashtagReducer
        extends Reducer<Text, Text, Text, Text> {

    private Text result = new Text();

    @Override
    public void reduce(Text key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {

        int totalLikes = 0;
        int totalRetweets = 0;

        for (Text value : values) {

            String[] data = value.toString().split(",");

            if (data.length == 2) {
                totalLikes += Integer.parseInt(data[0]);
                totalRetweets += Integer.parseInt(data[1]);
            }
        }

        int popularityScore = totalLikes + totalRetweets;

        result.set(
            totalLikes + "," +
            totalRetweets + "," +
            popularityScore
        );

        context.write(key, result);
    }
}
