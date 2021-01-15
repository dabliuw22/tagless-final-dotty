package com.leysoft

import com.leysoft.algebra.Applicative
import syntax.apply._
import syntax.functor._
import syntax.applicative._

sealed trait Program[F[_]]:
  def pure[A](a: A): F[A]
  def map[A, B](fa: F[A])(ff: A => B): F[B]
  def ap[A, B](fa: F[A])(ff: F[A => B]): F[B]

object Program:
  
  given instance[F[_]](using F: Applicative[F]): Program[F] with
    def pure[A](a: A): F[A] = a.pure
    def map[A, B](fa: F[A])(ff: A => B): F[B] = fa.fmap(ff)
    def ap[A, B](fa: F[A])(ff: F[A => B]): F[B] = fa <*> ff
  
  def make[F[_]](using F: Applicative[F])(using P: Program[F]): 
    F[Program[F]] = F.pure { P }
