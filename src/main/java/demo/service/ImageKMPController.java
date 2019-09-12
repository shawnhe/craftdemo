package demo.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import demo.algorithm.KMPMatch;
import demo.config.DemoConfig;
import demo.model.DemoResponse;
import demo.model.Image;
import demo.utils.Model;
import demo.model.MatchResult;
import demo.model.ProcessedData;

@RestController
public class ImageKMPController {
    Logger log = LoggerFactory.getLogger(ImageKMPController.class);

    @Autowired
    private DemoConfig config;

    //REST API to search for cat from an image file
    @PostMapping(value="/findTheCats/kmp", consumes = "application/json", produces = "application/json")
    public DemoResponse findTheCats(@Valid @RequestBody Image image) throws IOException {

    	// read out the server's cat file
    	ProcessedData cat = config.getCat();

    	// read out the request's frame file
        ProcessedData frame = Model.getFrame(image);

    	// match frame with the cat
    	List<MatchResult> list = KMPMatch.matchFrame(frame, cat, image.getThreshold());

    	// construct response with search results
    	DemoResponse response = new DemoResponse(list, list.size());

        return response;
    }
}
