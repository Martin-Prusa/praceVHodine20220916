package cz.martin.nobel;

import java.util.*;
import java.util.stream.Collectors;

public class NobelService {
    private NobelRepository repository = new NobelRepository();
    private List<Nobel> nobels = repository.load();

    public List<Nobel> getFirst() {
        var sorted = nobels.stream()
                .sorted(Comparator.comparingInt(Nobel::getYear))
                .toList();

        return sorted.stream()
                .filter(i -> i.getYear() == sorted.get(0).getYear())
                .toList();
    }

    public List<Nobel> getObama() {
        return nobels.stream()
                .filter((i) -> i.getWinner().equals("Barack Obama"))
                .toList();
    }

    public List<Nobel> getWar() {
        return nobels.stream()
                .filter((i) -> (i.getYear() >= 1914 && i.getYear() <= 1918) || (i.getYear() >= 1939 && i.getYear() <= 1945))
                .toList();
    }

    public Nobel getFirstEconomics() {
        return nobels.stream()
                .filter(i -> i.getSubject().equalsIgnoreCase("economics"))
                .min(Comparator.comparingInt(Nobel::getYear)).get();
    }

    public List<Nobel> getAfterEU() {
        int eu = nobels.stream()
                .filter(i -> i.getWinner().equalsIgnoreCase("European Union"))
                .min(Comparator.comparingInt(Nobel::getYear))
                .get()
                .getYear();

        return nobels.stream()
                .filter(i -> i.getYear() > eu)
                .toList();
    }

    public Map<String, Integer> getCounts() {
        Map<String, Integer> map = new HashMap<>();
        Set<String> subjects = nobels.stream().map(Nobel::getSubject).collect(Collectors.toSet());
        for (String subject : subjects) {
            map.put(subject, (int) nobels.stream().filter(i -> i.getSubject().equalsIgnoreCase(subject)).count());
        }
        return map;
    }

    public Set<String> getDuplicates() {
        List<String> winners = nobels.stream()
                .map(Nobel::getWinner)
                .toList();

        return winners.stream()
                .filter(i -> Collections.frequency(winners, i) > 1)
                .collect(Collectors.toSet());
    }
}
