package com.example.note_taking_md.service;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.stereotype.Service;


@Service
public class MarkDownService {

   private final Parser parser = Parser.builder().build();
   private final HtmlRenderer htmlRenderer = HtmlRenderer.builder().build();

    public String renderToHtml(String markdownContent) {
        if (markdownContent == null || markdownContent.trim().isEmpty()) {
            return "";
        }

        Node document = parser.parse(markdownContent);
        return htmlRenderer.render(document);
    }

}
