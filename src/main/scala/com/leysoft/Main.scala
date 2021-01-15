package com.leysoft

import interpreter.option.{given}
import interpreter.future.{given}
import syntax.applicative._
import syntax.apply._
import syntax.functor._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.Success

@main def run: Unit = {
  val program: Option[Program[Option]] = Program.make[Option]
  val option: Option[String] = program
    .flatMap(_.pure(1).fmap(_ + 2))
    .ap(((x: Int) => x * 2).pure) <*> ((x: Int) => x.toString).pure
  println(option)
  val future: Future[Int] = Future.successful(1) <> (_ + 2)
  future.onComplete {
    case Success(value) => println(value)
    case _              => println("Error...")
  }
}
