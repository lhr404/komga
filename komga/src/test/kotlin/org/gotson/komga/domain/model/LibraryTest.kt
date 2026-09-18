package org.gotson.komga.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.net.URI

class LibraryTest {
  @Test
  fun `given no scan interval when creating library then periodic scanning is disabled`() {
    val library = Library(name = "Test", root = URI("file:/library").toURL())

    assertThat(library.scanInterval).isEqualTo(Library.ScanInterval.DISABLED)
  }

  @Test
  fun `given explicit scan interval when creating library then interval is preserved`() {
    val library =
      Library(
        name = "Test",
        root = URI("file:/library").toURL(),
        scanInterval = Library.ScanInterval.EVERY_6H,
      )

    assertThat(library.scanInterval).isEqualTo(Library.ScanInterval.EVERY_6H)
  }
}
