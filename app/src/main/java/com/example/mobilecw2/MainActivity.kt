package com.example.mobilecw2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.room.Room
import kotlinx.android.synthetic.main.popup_window.view.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
•Name   : Adeesha Arunoda Gunawardana
•UoW ID : w1867103
•IIT ID : 20210348
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val tv = findViewById<TextView>(R.id.tv)
//        tv.setText("")

        //creating the Database
        val db = Room.databaseBuilder(this, MovieDatabase ::class.java,"mydatabase").build()

        val movieDao = db.movieDao()



        val addMoviesBtn = findViewById<Button>(R.id.b1) //Add Movies Button
        val searchMoviesBtn = findViewById<Button>(R.id.b2) //Search Movies Button
        val searchActorsBtn = findViewById<Button>(R.id.b3) //Search Actors Button
        val viewDatabaseBtn = findViewById<Button>(R.id.b8) //View Database Button
        val viewPopupMovieBtn = findViewById<Button>(R.id.b7) //Search Button in Popup

        addMoviesBtn.setOnClickListener {
                runBlocking {
                    launch {
                        val movie1 = MovieEntity(
                            "The Shawshank Redemption",
                            "1994",
                            "R",
                            "14 Oct 1994",
                            "142 min",
                            "Drama",
                            "Frank Darabont",
                            "Stephen King, Frank Darabont",
                            "Tim Robbins, Morgan Freeman, Bob Gunton",
                            "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency."
                        )
                        val movie2 = MovieEntity(
                            "Batman: The Dark Knight Returns, Part 1",
                            "2012",
                            "PG-13",
                            "25 Sep 2012",
                            "76 min",
                            "Animation, Action, Crime, Drama, Thriller",
                            "Jay Oliva",
                            "Bob Kane (character created by: Batman), Frank Miller (comic book), Klaus Janson (comic book), Bob Goodman",
                            "Peter Weller, Ariel Winter, David Selby, Wade Williams",
                            "Batman has not been seen for ten years. A new breed of criminal ravages Gotham City, forcing 55-year-old Bruce Wayne back into the cape and cowl. But, does he still have what it takes to fight crime in a new era?"
                        )
                        val movie3 = MovieEntity(
                            "The Lord of the Rings: The Return of the King",
                            "2003",
                            "PG-13",
                            "17 Dec 2003",
                            "201 min",
                            "Action, Adventure, Drama",
                            "Peter Jackson",
                            "J.R.R. Tolkien, Fran Walsh, Philippa Boyens",
                            "Elijah Wood, Viggo Mortensen, Ian McKellen",
                            "Gandalf and Aragorn lead the World of Men against Saurons army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring."
                        )
                        val movie4 = MovieEntity(
                            "Inception",
                            "2010",
                            "PG-13",
                            "16 Jul 2010",
                            "148 min",
                            "Action, Adventure, Sci-Fi",
                            "Christopher Nolan",
                            "Christopher Nolan",
                            "Leonardo DiCaprio, Joseph Gordon-Levitt, Elliot Page",
                            "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O., but his tragic past may doom the project and his team to disaster.",
                        )
                        val movie5 = MovieEntity(
                            "The Matrix",
                            "1999",
                            "R",
                            "31 Mar 1999",
                            "136 min",
                            "Action, Sci-Fi",
                            "Lana Wachowski, Lilly Wachowski",
                            "Lilly Wachowski, Lana Wachowski",
                            "Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss",
                            "When a beautiful stranger leads computer hacker Neo to a forbidding underworld, he discovers the shocking truth--the life he knows is the elaborate deception of an evil cyber-intelligence."
                        )

                        //Adding the Data
                        movieDao.insertMovies(movie1, movie2, movie3, movie4, movie5)



                        //movieDao.deleteAll()

//                        val movies: List<MovieEntity> = movieDao.getAll()
//                        for (M in movies) {
//                            tv.append("\n ${M.title} ${M.year} ${M.rated} ${M.released} ${M.runtime} ${M.genre} ${M.director} ${M.writer} ${M.actors} ${M.plot}")
//                        }


                    }
                }
        }
        searchMoviesBtn.setOnClickListener {
            val newGameIntent = Intent(this,SearchMovies::class.java)//accessing the SearchMovies class
            startActivity(newGameIntent)
        }

        searchActorsBtn.setOnClickListener {
            val newGameIntent2 = Intent(this,SearchActors::class.java)//accessing the SearchActors class
            startActivity(newGameIntent2)
        }

        viewDatabaseBtn.setOnClickListener {
            val newGameIntent3 = Intent(this,ViewDatabase::class.java)//accessing the viewDatabase class
            startActivity(newGameIntent3)
        }

        viewPopupMovieBtn.setOnClickListener {
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.popup_window,null)
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("Login Form")

            //Show Dialog
            val mAlertDialog = mBuilder.show()

            //Search button click custom layout
            mDialogView.popUpSearchButton.setOnClickListener {
                //dismiss dialog
                mAlertDialog.dismiss()
                //Get text from EditTexts of Custom Layout

                val name = mDialogView.dialogTE.text.toString()

                //set input text in text view

            }
            //cancel button of custom layout
            mDialogView.popUpCancelButton.setOnClickListener {
                //dismiss dialog
                mAlertDialog.dismiss()


            }
        }

    }

}