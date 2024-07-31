package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ1620 {

    static int N, M;
    static Set<String> pokemonDogam = new LinkedHashSet<>();
    static Map<String, Integer> reversePokemonDogam = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {

            String pokemon = br.readLine();

            pokemonDogam.add(pokemon);

            if(reversePokemonDogam.get(pokemon) == null)
                reversePokemonDogam.put(pokemon, i+1);
        }

        List<String> listPokemonDogam = new ArrayList<>(pokemonDogam);

        for(int j = 0; j < M; j++) {
            String command = br.readLine();
            boolean isNum = false;

            for(int num = 0; num < 10; num++)
                if(command.charAt(0) - '0' == num) {
                    isNum = true;
                    break;
                }

            if(isNum)
                System.out.println(listPokemonDogam.get( Integer.parseInt(command) - 1 ));
            else
                System.out.println(reversePokemonDogam.get(command));
        }
    }
}
