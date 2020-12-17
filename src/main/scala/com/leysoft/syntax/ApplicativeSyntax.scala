package com.leysoft.syntax

import com.leysoft.algebra.Applicative

private[syntax] trait ApplicativeSyntax {

  def [F[_], A](a: A).pure(using G: Applicative[F]): F[A] = G.pure(a)
}
