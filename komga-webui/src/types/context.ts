export enum ContextOrigin {
  SERIES = 'SERIES',
  READLIST = 'READLIST',
  LIBRARY = 'LIBRARY',
  COLLECTION = 'COLLECTION',
  RANDOM = 'RANDOM',
}

export interface Context {
  origin: ContextOrigin,
  id: string,
}
