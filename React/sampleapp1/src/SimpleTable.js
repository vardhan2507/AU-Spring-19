import React from 'react';
import PropTypes from 'prop-types';
import { withStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
import Switch from '@material-ui/core/Switch';
import EditIcon from '@material-ui/icons/Edit';
import Checkbox from '@material-ui/core/Checkbox';

const styles = {
  root: {
    width: '100%',
    overflowX: 'auto',
  },
  table: {
    minWidth: 700,
  },
};

let id = 0;
function createData(name, price, availability, editop) {
  id += 1;
  return { id, name, price, availability, editop };
}

const  data = [
  createData('Veg Curry', 20, true, ""),
  createData('Egg Curry', 30, false, ""),
  createData('Chicken Curry', 50, true, ""),
  
];

function SimpleTable(props) {
  const { classes } = props;

  return (
    <Paper className={classes.root}>
      <Table className={classes.table}>
        <TableHead style={{backgroundColor:"#000000"}}>
          <TableRow >
          <TableCell style={{color:"#ffffff"}}>Select</TableCell>
            <TableCell style={{color:"#ffffff"}}>Item Name</TableCell>
            <TableCell style={{color:"#ffffff"}} align="right">Price</TableCell>
            <TableCell style={{color:"#ffffff"}} align="right">Is Available?</TableCell>
            <TableCell style={{color:"#ffffff"}} align="right">Edit</TableCell>
            
          </TableRow>
        </TableHead>
        <TableBody>
          {data.map(n => {
            return (
              <TableRow key={n.id}>
              <TableCell align="left"><Checkbox/></TableCell>
                <TableCell component="th" scope="row">
                  {n.name}
                </TableCell>
                <TableCell align="right">{n.price}</TableCell>
                <TableCell align="right"><Switch/></TableCell>
                <TableCell align="right"><EditIcon/></TableCell>
        
              </TableRow>
            );
          })}
          <TableRow>
          <TableCell colSpan="2" align="center">Grand Total</TableCell>
          <TableCell></TableCell>

          </TableRow>
        </TableBody>
      </Table>
    </Paper>
  );
}

SimpleTable.propTypes = {
  classes: PropTypes.object.isRequired,
};

export default withStyles(styles)(SimpleTable);