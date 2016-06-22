package com.variz.hadoop.wordcount;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable>{

	@Override
	protected void map(LongWritable key, Text value,
			Mapper<LongWritable, Text, Text, IntWritable>.Context context)
					throws IOException, InterruptedException {
		
		String currentLine = value.toString();
		String [] words = currentLine.split(" ");
		for(String word : words) {
			Text outputKey = new Text(word);
			context.write(outputKey, new IntWritable(1));
		}
	}
}