import React from 'react';
import { ButtonForm } from './ButtonForm';
import { TextField } from './TextField';

export const AddPlace= () => (
<form className="fixed-bottom">
  <div class="form-row align-items-center">

    <div className="form-group">
    <TextField type="text" placeholder="New Place" name="addPlace" id="inlineFormInputName"></TextField>
    <ButtonForm type="submit">Add</ButtonForm>
    </div>

  </div>
</form>
)