package com.will_martin.application;

import com.will_martin.domain.DoubleDateDiffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

@RestController
public class DoubleDateDiffController {
    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    private final DoubleDateDiffService doubleDateDiffService;

    @Autowired
    public DoubleDateDiffController(DoubleDateDiffService doubleDateDiffService) {
        this.doubleDateDiffService = doubleDateDiffService;
    }

    @GetMapping(value = "/doubledatediff/{dateOne}/{dateTwo}")
    public ResponseEntity<String> getDoubleDateDiff(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateOne,
                                                  @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateTwo) {
        final Date result = doubleDateDiffService.getDoubleDateDiff(dateOne, dateTwo);
        return ResponseEntity.ok(formatter.format(result));
    }
}
