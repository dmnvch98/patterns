package org.example.composite;

import java.util.List;

public class Messenger {
    LetterComposite messageFromOrcs () {
        var words = List.of(
            new Word('W', 'h', 'e', 'r', 'e'),
            new Word('t', 'h', 'e', 'r', 'e'),
            new Word('i', 's'),
            new Word('a'),
            new Word('w', 'h', 'i', 'p'),
            new Word('t', 'h', 'e', 'r', 'e'),
            new Word('i', 's'),
            new Word('a'),
            new Word('w', 'a', 'y')
        );
        return new Sentence(words);
    }
}
