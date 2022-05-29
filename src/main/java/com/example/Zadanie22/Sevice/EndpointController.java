package com.example.Zadanie22.Sevice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.example.Zadanie22.Sevice.EndpiontService.end1;
import static com.example.Zadanie22.Sevice.EndpiontService.end2;

@RestController
@RequestMapping("/CSV")
public class EndpointController {
    @GetMapping("/1/{size}")
    public static void endpoint1(HttpServletResponse response, @PathVariable int size) throws IOException {
        response.setContentType("text/plain; charset=utf-8");
        response.getWriter().print(end1(size));

    }
    @GetMapping("/2/{size}/{requestList}")
    public static void endpoint2(HttpServletResponse response, @PathVariable int size, @PathVariable List<String> requestList) throws IOException {
        response.setContentType("text/plain; charset=utf-8");
        response.getWriter().print(end2(size, requestList));
    }
}
