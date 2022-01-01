import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BalancedBracketsTest {
    @Test
    public void test() {
        String[] input = new String[]{
                "()[{}()]([[][]()[[]]]{()})([]()){[]{}}{{}}{}(){([[{}([]{})]])}",
                "{][({(}]][[[{}]][[[())}[)(]([[[)][[))[}[]][()}))](]){}}})}[{]{}{((}]}{{)[{[){{)[]]}))]()]})))[",
                "[)](][[([]))[)",
                "]}]){[{{){",
                "{[(}{)]]){(}}(][{{)]{[(((}{}{)}[({[}[}((}{()}[]})]}]]))((]][[{{}[(}})[){()}}{(}{{({{}[[]})]{((]{[){[",
                "()}}[(}])][{]{()([}[}{}[{[]{]](]][[))(()[}(}{[{}[[]([{](]{}{[){()[{[{}}{[{()(()({}([[}[}[{(]})",
                "){[])[](){[)}[)]}]]){](]()]({{)(]])(]{(}(}{)}])){[{}((){[({(()[[}](]})]}({)}{)]{{{",
                "[(})])}{}}]{({[]]]))]})]",
                "[{",
                "{}([{()[]{{}}}])({})",
                "{({}{[({({})([[]])}({}))({})]})}",
                "()[]",
                "{)[])}]){){]}[(({[)[{{[((]{()[]}][([(]}{](])()(}{(]}{})[)))[](){({)][}()((",
                "[][(([{}])){}]{}[()]{([[{[()]({}[])()()}[{}][]]])}",
                "(}]}",
                "(([{()}]))[({[{}{}[]]{}})]{((){}{()}){{}}}{}{{[{[][]([])}[()({}())()({[]}{{[[]]([])}})()]]}}",
                "[(([){[](}){){]]}{}([](([[)}[)})[(()[]){})}}]][({[}])}{(({}}{{{{])({]]}[[{{(}}][{)([)]}}",
                "()()[()([{[()][]{}(){()({[]}[(((){(())}))]()){}}}])]",
                "({)}]}[}]{({))}{)]()(](])})][(]{}{({{}[]{][)){}{}))]()}((][{]{]{][{}[)}}{)()][{[{{[[",
                ")}(()[])(}]{{{}[)([})]()}()]}(][}{){}}})}({](){([()({{(){{",
                "}([]]][[){}}[[)}[(}(}]{(}[{}][{}](}]}))]{][[}(({(]}[]{[{){{(}}[){[][{[]{[}}[)]}}]{}}(}"
        };

        String[] expected = new String[] {
                "YES",
                "NO",
                "NO",
                "NO",
                "NO",
                "NO",
                "NO",
                "NO",
                "NO",
                "YES",
                "YES",
                "YES",
                "NO",
                "YES",
                "NO",
                "YES",
                "NO",
                "YES",
                "NO",
                "NO",
                "NO"
        };

        for (int i = 0; i < input.length; i++) {
            System.out.println(i);
            String result = BalancedBrackets.isBalanced(input[i]);
            Assertions.assertEquals(expected[i], result);
        }
    }
}
