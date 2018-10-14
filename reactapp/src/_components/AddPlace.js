import React from 'react';
import { ButtonForm } from './ButtonForm';
import { TextField } from './TextField';

export const AddPlace= () => (
<form>
  <div className="form-row my-2">
  <div className="col-9 float-left">
    <TextField type="text" placeholder="New Place" name="addPlace" id="inlineFormInputName"></TextField>
  </div>
  <div className="col-2 float-right">
    <ButtonForm type="submit" name="Add"></ButtonForm>
  </div>
  <div className="col-1"></div>
  </div>
</form>
)