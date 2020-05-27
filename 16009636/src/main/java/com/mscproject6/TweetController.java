package com.mscproject6;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TweetController {

@Autowired
private TweetDB tweetDB;
@GetMapping("/allTweets")
@ResponseBody
public List<Tweet> getTweets() {




	return tweetDB.selectAll();
}
}
