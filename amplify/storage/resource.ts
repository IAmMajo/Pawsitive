import { defineStorage } from '@aws-amplify/backend';

export const storage = defineStorage({
  name: 'storage',
  access: (allow) => ({
    'vet-pictures': [
      allow.guest.to(['get']),
    ],
    'clinic-pictures': [
      allow.guest.to(['get']),
    ],
    'pet-pictures/{entity_id}/*': [
      allow.guest.to(['get']),
      allow.entity('identity').to(['get', 'write', 'delete']),
    ],
  }),
});
