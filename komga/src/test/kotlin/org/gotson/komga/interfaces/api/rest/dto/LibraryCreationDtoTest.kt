package org.gotson.komga.interfaces.api.rest.dto

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LibraryCreationDtoTest {
  private val mapper = jacksonObjectMapper()

  @Test
  fun `given omitted scan interval when deserializing creation request then periodic scanning is disabled`() {
    val request = mapper.readValue<LibraryCreationDto>("""{"name":"Test","root":"/library"}""")

    assertThat(request.scanInterval).isEqualTo(ScanIntervalDto.DISABLED)
  }

  @Test
  fun `given explicit scan interval when deserializing creation request then interval is preserved`() {
    val request =
      mapper.readValue<LibraryCreationDto>("""{"name":"Test","root":"/library","scanInterval":"EVERY_6H"}""")

    assertThat(request.scanInterval).isEqualTo(ScanIntervalDto.EVERY_6H)
  }
}
