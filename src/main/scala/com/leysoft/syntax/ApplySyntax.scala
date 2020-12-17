package com.leysoft.syntax

import com.leysoft.algebra.Apply

private[syntax] trait ApplySyntax {

  extension [F[_], A, B](fa: F[A]):
    def ap(ff: F[A => B])(using F: Apply[F]): F[B] = F.ap(ff)(fa)
    def <*>(ff: F[A => B])(using F: Apply[F]): F[B] = fa.ap(ff)
    def *>(fb: F[B])(using F: Apply[F]): F[B] = F.productR(fa)(fb)
}
