package com.example.movies.data

import javax.inject.Inject

class MoviesData @Inject constructor() {

    val movies = listOf(
        Movie(
            "https://xl.movieposterdb.com/21_12/2022/5108870/xl_5108870_8cd5990e.jpg?v=2023-04-25%2000:31:15",
            "Morbius"
        ),
        Movie(
            "https://xl.movieposterdb.com/22_02/2022/4123432/xl_4123432_6baf9dac.jpg?v=2023-04-25%2000:57:27",
            "Fantastic Beasts: The Secrets of Dumbledore"
        ),
        Movie(
            "https://xl.movieposterdb.com/22_02/2022/11304712/xl_11304712_f952efe8.jpg?v=2023-06-15%2007:38:36",
            "Doctor Strange in the Multiverse of Madness"
        ),
        Movie(
            "https://xl.movieposterdb.com/23_06/2022/11290914/xl_spider-man-across-the-spider-verse-part-one-movie-poster_37d41ec0.jpg?v=2023-07-05%2017:04:42",
            "Spider-Man: Across the Spider-Verse"
        ),
        Movie(
            "https://xl.movieposterdb.com/23_02/2021/6791350/xl_guardians-of-the-galaxy-vol-3-movie-poster_1aa9e0b7.jpg?v=2023-07-05%2004:39:41",
            "Guardians of the Galaxy Vol. 3"
        ),
        Movie(
            "https://xl.movieposterdb.com/23_06/2023/439572/xl_the-flash-movie-poster_e7957c79.jpg?v=2023-07-05%2007:44:28",
            "The Flash"
        ),
        Movie(
            "https://xl.movieposterdb.com/22_05/2020/1745960/xl_1745960_cc176006.jpg?v=2023-06-30%2009:48:08",
            "Top Gun: Maverick"
        ),
        Movie(
            "https://xl.movieposterdb.com/23_04/2022/5090568/xl_transformers-rise-of-the-beasts-movie-poster_c216a1be.jpg?v=2023-07-04%2018:57:21",
            "Transformers: Rise of the Beasts"
        ),
        Movie(
            "https://xl.movieposterdb.com/13_05/2013/770828/xl_770828_3dd6384a.jpg?v=2023-06-30%2009:48:01",
            "Man of Steel"
        ),
    )
}