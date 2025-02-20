package boj;

import java.util.*;
import java.io.*;

// 나이순 정렬
public class Silver5_Q10814 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        String[] line;

        Person[] p = new Person[N];

        for (int i = 0; i < N; i++) {
            line = br.readLine().split(" ");
            p[i] = new Person(Integer.parseInt(line[0]), line[1]);
        }

        Arrays.sort(p, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.age - o2.age;
            }
        });

        StringBuilder sb = new StringBuilder();

        for (Person person : p) {
            sb.append(person.toString()).append("\n");
        }

        System.out.println(sb);
    }

    public static class Person {
        int age;
        String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString(){
            return age + " " + name;
        }
    }
}
