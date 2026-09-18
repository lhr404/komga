import { describe, expect, test } from 'vitest'
import { getLibraryDefaults } from '@/functions/libraries'

describe('library defaults', () => {
  test('periodic scanning is disabled for new libraries', () => {
    expect(getLibraryDefaults().scanInterval).toBe('DISABLED')
  })
})
