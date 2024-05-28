package com.example.lab_kot104.lab6

data class Movie(
    val title: String,
    val year: String,
    val posterUrl: String,
    val duration: String,
    val releaseDate: String,
    val genre: String,
    val shotDescription: String
) {
    companion object {
        fun getSampleMovies() = listOf(
            Movie(
                title = "The Shawshank Redemption",
                year = "1994",
                posterUrl = "https://ae01.alicdn.com/kf/HTB1mWWMXuGSBuNjSspbq6AiipXaH/The-Shawshank-Redemption-Retro-Vintage-Classic-Movie-Poster-Canvas-Painting-Wall-Sticker-Home-Art-Home-Decoration.jpg",
                duration = "2h 22m",
                releaseDate = "14 October 1994",
                genre = "Drama",
                shotDescription = "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency."
            ),
            Movie(
                title = "The Godfather",
                year = "1972",
                posterUrl = "https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg",
                duration = "2h 55m",
                releaseDate = "24 March 1972",
                genre = "Crime, Drama",
                shotDescription = "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son."
            ),
            Movie(
                title = "The Dark Knight",
                year = "2008",
                posterUrl = "https://m.media-amazon.com/images/S/pv-target-images/e9a43e647b2ca70e75a3c0af046c4dfdcd712380889779cbdc2c57d94ab63902.jpg",
                duration = "2h 32m",
                releaseDate = "18 July 2008",
                genre = "Action, Crime, Drama",
                shotDescription = "When the menace known as the Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham."
            ),
            Movie(
                title = "Pulp Fiction",
                year = "1994",
                posterUrl = "https://m.media-amazon.com/images/S/pv-target-images/dbb9aff6fc5fcd726e2c19c07f165d40aa7716d1dee8974aae8a0dad9128d392.jpg",
                duration = "2h 34m",
                releaseDate = "14 October 1994",
                genre = "Crime, Drama",
                shotDescription = "The lives of two mob hitmen, a boxer, a gangster's wife, and a pair of diner bandits intertwine in four tales of violence and redemption."
            ),
            Movie(
                title = "The Lord of the Rings: The Return of the King",
                year = "2003",
                posterUrl = "https://m.media-amazon.com/images/M/MV5BNDgwY2YyNjctZTMxZC00ZTRlLThhN2QtMTAwYjUyODcyZDYxXkEyXkFqcGdeQXVyMTA0MTM5NjI2._V1_FMjpg_UX1000_.jpg",
                duration = "3h 21m",
                releaseDate = "17 December 2003",
                genre = "Action, Adventure, Drama",
                shotDescription = "Gandalf and Aragorn lead the World of Men against Sauron's army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring."
            ),
            Movie(
                title = "Forrest Gump",
                year = "1994",
                posterUrl = "https://afamilycdn.com/Images/Uploaded/Share/2010/02/02/forrestgumpadv.jpg",
                duration = "2h 22m",
                releaseDate = "6 July 1994",
                genre = "Drama, Romance",
                shotDescription = "The presidencies of Kennedy and Johnson, the events of Vietnam, Watergate, and other history unfold through the perspective of an Alabama man with an IQ of 75."
            ),
            Movie(
                title = "Inception",
                year = "2010",
                posterUrl = "https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_.jpg",
                duration = "2h 28m",
                releaseDate = "16 July 2010",
                genre = "Action, Adventure, Sci-Fi",
                shotDescription = "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a CEO."
            ),
            Movie(
                title = "Fight Club",
                year = "1999",
                posterUrl = "https://m.media-amazon.com/images/M/MV5BMmEzNTkxYjQtZTc0MC00YTVjLTg5ZTEtZWMwOWVlYzY0NWIwXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_FMjpg_UX1000_.jpg",
                duration = "2h 19m",
                releaseDate = "15 October 1999",
                genre = "Drama",
                shotDescription = "An insomniac office worker and a devil-may-care soapmaker form an underground fight club that evolves into much more."
            ),
            Movie(
                title = "The Matrix",
                year = "1999",
                posterUrl = "https://cdn.mos.cms.futurecdn.net/bWY8qDEGRhaZv2DE7vaokj-1200-80.jpg",
                duration = "2h 16m",
                releaseDate = "31 March 1999",
                genre = "Action, Sci-Fi",
                shotDescription = "A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers."
            ),
            Movie(
                title = "Goodfellas",
                year = "1990",
                posterUrl = "https://m.media-amazon.com/images/M/MV5BY2NkZjEzMDgtN2RjYy00YzM1LWI4ZmQtMjIwYjFjNmI3ZGEwXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg",
                duration = "2h 26m",
                releaseDate = "21 September 1990",
                genre = "Biography, Crime, Drama",
                shotDescription = "The story of Henry Hill and his life in the mob, covering his relationship with his wife Karen Hill and his mob partners Jimmy Conway and Tommy DeVito."
            )
        )
    }
}
