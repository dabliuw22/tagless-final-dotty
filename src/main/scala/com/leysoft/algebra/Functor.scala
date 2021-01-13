package com.leysoft.algebra

trait Functor[F[_]]:
  def fmap[A, B](fa: F[A])(f: A => B): F[B]

object Functor:
  inline def apply[F[_]](using F: Functor[F]): Functor[F] = F
