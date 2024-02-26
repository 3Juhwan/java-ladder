package view;

import domain.db.Name;
import domain.db.Names;
import domain.db.Prize;
import domain.db.Prizes;
import domain.ladder.Bridge;
import domain.ladder.Ladder;
import domain.ladder.Line;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final int SINGLE_BRIDGE_LENGTH = 5;
    private static final String BRIDGE_SEPARATOR = "|";
    private static final String BRIDGE_LEFT_MARGIN = "     ";


    public static void printResult(final Names names, final Ladder ladder, final Prizes prizes) {
        System.out.println(System.lineSeparator() + "실행 결과");
        printPlayers(names.names());
        printLadder(ladder);
        printPrizes(prizes.prizes());
    }

    public static void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    private static void printPlayers(final List<Name> names) {
        System.out.println(makePlayersNameMessage(names));
    }

    private static String makePlayersNameMessage(final List<Name> names) {
        return names.stream()
                .map(name -> String.format("%6s", name.name()))
                .collect(Collectors.joining());
    }

    private static void printLadder(final Ladder ladder) {
        ladder.getLines().stream()
                .map(OutputView::makeLineMessage)
                .forEach(System.out::println);
    }

    private static String makeLineMessage(final Line line) {
        return BRIDGE_LEFT_MARGIN +
                line.getBridges().stream()
                        .map(OutputView::makeBridgeMessage)
                        .collect(Collectors.joining(BRIDGE_SEPARATOR, BRIDGE_SEPARATOR, BRIDGE_SEPARATOR));
    }

    private static String makeBridgeMessage(final Bridge bridge) {
        return bridge.getSymbol().repeat(SINGLE_BRIDGE_LENGTH);
    }

    private static void printPrizes(final List<Prize> prizes) {
        System.out.println(makePrizesNameMessage(prizes));
    }

    private static String makePrizesNameMessage(final List<Prize> prizes) {
        return prizes.stream()
                .map(prize -> String.format("%6s", prize.name()))
                .collect(Collectors.joining());
    }
}
