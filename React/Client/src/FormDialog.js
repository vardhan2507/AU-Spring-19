import React from 'react';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
import DialogTitle from '@material-ui/core/DialogTitle';
import Fab from '@material-ui/core/Fab';
import AddIcon from '@material-ui/icons/Add';
import Switch from '@material-ui/core/Switch';
import PropTypes from 'prop-types';
import Dashboard from './Dashboard';

const styles = theme => ({
    root: {
      display: 'flex',
    },
    fab: {
      margin: theme.spacing.unit,
    },
});



export default class FormDialog extends React.Component {
  state = {
    open: false,
  };
  
 
  handleClickOpen = () => {
    this.setState({ open: true });
  };

  handleClose = () => {
    this.setState({ open: false });
  };

  getContent(event) {
    this.props.callback(event.target.value);
    }
 

    
  render() {

    return (
      <div>
        <div align="right">
        <Fab color="primary" aria-label="Add"  >
        <AddIcon  onClick={this.handleClickOpen}/>
      </Fab>
     
      </div>
        
        <Dialog
          open={this.state.open}
          onClose={this.handleClose}
          aria-labelledby="form-dialog-title"
        >
          <DialogTitle id="form-dialog-title">Item</DialogTitle>
          <DialogContent>
            <TextField
              autoFocus
              margin="dense"
              id="name"
              label="Item Name"
              type="text"
              fullWidth
            />
            <TextField
              autoFocus
              margin="dense"
              id="price"
              label="Price"
              type="number"
              fullWidth
            />
            <TextField
              autoFocus
              margin="dense"
              id="name"
              label="Email Address"
              type="switch"
              fullWidth
            />
            
            <DialogContentText>
                Is Available?
                <Switch></Switch>
            </DialogContentText>
          </DialogContent>
          <DialogActions>
            <Button onClick={this.handleClose} color="primary">
              Ok
            </Button>
            <Button onClick={this.handleClose} color="primary">
            Cancel
            </Button>
          </DialogActions>
        </Dialog>
      </div>
    );
  }
}

